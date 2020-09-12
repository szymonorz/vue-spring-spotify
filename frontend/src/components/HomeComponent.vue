<template>
    <div v-if="this.$http.defaults.headers.common['Authorization']">
      <SearchBar :token="this.token" v-on:get-info="showInfo($event)"/>
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
      token: String
    }
  }, 
  mounted(){
    this.auth = this.$route.query.token
    if(this.auth)
    {
        this.$http.get("http://192.168.0.30:8081/getToken")
        .then(resp => this.assignToken(resp.data))
        .catch(err => console.log(err.response.status));
        
    }
  },
  methods:{
    showInfo: function(artistID)
    {
        console.log("redirect")
        this.$router.push({name: "artist", params: {id: artistID}})
    },
    assignToken: function(token)
    {
        console.log(token)
        this.$http.defaults.headers.common["Authorization"] = "Bearer " + token
        console.log(this.$http.defaults.headers.common['Authorization'])
        console.log(this.$http.defaults.headers)
    }
  },
}
</script>