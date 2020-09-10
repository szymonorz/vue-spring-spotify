<template>
  <div id="app">
    <div v-if="this.token">
      <SearchBar :token="this.token" v-on:show-info="showInfo($event)"/>

      <div v-if="loaded">
      <vk-modal-full :show.sync="show">
          <vk-modal-full-close large @click="show = false"></vk-modal-full-close>
          <vk-grid collapse class="uk-child-width-1-2@s uk-flex-middle" style="height: 100%">
            <div class="uk-background-cover" 
              id="image"
              :style="{'background': 'url('+imgUrl+')'}"
            vk-height-viewport="{min-heigh: 500}">
            </div>
            <div class="uk-padding-large">
              <h1>{{this.artistData["Artist"]["name"]}}</h1>
              <p>Lorem ipsum dolor sit amet,
                 consectetur adipiscing elit, sed do eiusmod tempor incididunt ut 
                 labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
                 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis 
                 aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat 
                 nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
          </vk-grid>
    </vk-modal-full>
    </div>
    </div>
    <div v-else>
      <SpotifyButton v-bind:msg="message"/>
    </div>
  </div>
</template>

<script>
import SearchBar from './components/SearchBar'
import SpotifyButton from "./components/SpotifyButton"
import {ModalFull, ModalFullClose} from "vuikit/lib/modal"
import {Grid} from "vuikit/lib/grid"
export default {
  name: 'App',
  components: {
    SearchBar,
    SpotifyButton,
    VkModalFull: ModalFull,
    VkGrid: Grid,
    VkModalFullClose: ModalFullClose,
  },
  data(){
    return{
      message: "Zaloguj się do Spotify",
      token: "",
      headers: {
        "Authorization": this.encoded
      },
      show: Boolean,
      artistData: Object,
      loaded: Boolean,
      imgUrl: String
    }
  },
  methods:{
    showInfo: function(data)
    {
        this.artistData = data
        console.log(this.artistData)
        this.loaded = true;
        this.show = true
        this.imgUrl = "'"+data["Artist"]["images"][0]["url"]+"'"
        console.log(this.imgUrl)
    }
  },
  mounted(){
    this.show = false
    this.loaded = false;
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

#image
{
  height: 100%;
}
</style>
