<template>
    <div v-if="this.token">
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
      token: "",
      show: Boolean
    }
  }, 
  mounted(){
    this.token = this.$route.query.token
  },
  methods:{
    showInfo: function(artistID)
    {
        console.log("redirect")
        this.$router.push({name: "artist", params: {id: artistID}, query: {token: this.token}})
    }
  },
}
</script>