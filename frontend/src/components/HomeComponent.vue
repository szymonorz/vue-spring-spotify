<template>
    <div v-if="this.token">
        <SearchBar v-on:get-info="showInfo($event)" v-on:handle-error="handleError($event)"/>
        
    </div>
    <div v-else>
      <SpotifyButton v-bind:msg="message"/>
    </div>
</template>
<script>
import SearchBar from './SearchBar'
import SpotifyButton from "./SpotifyButton"
export default {
  name: 'Home',
  components: {
    SearchBar,
    SpotifyButton
  },
  data(){
    return{
      message: "Zaloguj się do Spotify",
      auth: "",
      show: Boolean,
      token: ""
    }
  }, 
  mounted(){
    this.auth = this.$route.query.token
    this.$http.get("http://192.168.0.30:8081/getToken")
            .then(resp => this.assignToken(resp.data))
            .catch(err => console.log(err));
        
  },
  methods:{
    showInfo: function(artistID)
    {
        this.$router.push({name: "artist", params: {id: artistID}})
    },
    assignToken: function(token)
    {
        if(token){
            this.$http.defaults.headers.common["Authorization"] = "Bearer " + token
            this.token = this.$http.defaults.headers.common['Authorization']
        }
        
    },
    handleError: function(code)
    {
        if(code == 401)
            this.$http.defaults.headers.common["Authorization"] = ""
    }
  },
}
</script>