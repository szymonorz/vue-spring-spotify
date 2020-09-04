<template>
  <div id="app">
    <div v-if="this.token">
      <SearchBar :token="this.token"/>
    </div>
    <div v-else>
      <SpotifyButton v-bind:msg="message"/>
    </div>
  </div>
</template>

<script>
import SearchBar from './components/SearchBar'
import SpotifyButton from "./components/SpotifyButton"
export default {
  name: 'App',
  components: {
    SearchBar,
    SpotifyButton
  },
  data(){
    return{
      message: "Zaloguj się do Spotify",
      token: "",
      headers: {
        "Authorization": this.encoded
      }
    }
  },
  mounted(){
    this.token = this.$route.query.token
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
