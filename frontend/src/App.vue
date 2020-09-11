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
            <div>
              <h1>{{this.artistData["Artist"]["name"]}}</h1>
              <h5>Followers: {{this.followers}}</h5>
            <vk-tabs>
              <vk-tabs-item title="General">
                  <div class="genres" style="display: flex">Genres: 
                      <div v-for="genre in genres" 
                      :key="genre">
                        <b><i>{{genre}}</i></b>
                      </div> 
                  </div>
              </vk-tabs-item>
              <vk-tabs-item title="Top songs">
                <div class="parent-element" style="height: 300px">
                  <vue-scroll>
                    <table class="child-element">
                      <tr><td>Album photo</td><td>Song name</td><td>Song popularity</td></tr>
                      <tr v-for="track in topSongs"
                      :key="track">
                        <td><img :src="track['album']['images'][0]['url']" height="100px" width="100px"/></td>
                        <td>{{track['name']}}</td>
                        <td>{{track['popularity']}}</td>
                      </tr>
                    </table>
                  </vue-scroll>
                </div>
              </vk-tabs-item>
            </vk-tabs>

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
import vuescroll from "vuescroll"
import {ModalFull, ModalFullClose} from "vuikit/lib/modal"
import {Grid} from "vuikit/lib/grid"
import {Tabs, TabsItem} from "vuikit/lib/tabs"
export default {
  name: 'App',
  components: {
    SearchBar,
    SpotifyButton,
    VkModalFull: ModalFull,
    VkGrid: Grid,
    VkModalFullClose: ModalFullClose,
    VkTabs: Tabs,
    VkTabsItem: TabsItem,
    VueScroll: vuescroll
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
      imgUrl: String,
      genres: Array,
      followers: String,
      topSongs: Array,
      ops: {
          vuescroll: {},
          scrollPanel: {},
          rail: {},
          bar: {}
        }
    }
  },
  methods:{
    showInfo: function(data)
    {
        this.artistData = data
        console.log(this.artistData)
        this.loaded = true;
        this.show = true
        this.loadUserData(this.artistData)
    },
    loadUserData: function(data)
    {

        this.imgUrl = "'"+data["Artist"]["images"][0]["url"]+"'"
        this.genres = data["Artist"]["genres"]
        this.followers = data["Artist"]["followers"]["total"]
        this.topSongs = data["Top-Tracks"]["tracks"]
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
