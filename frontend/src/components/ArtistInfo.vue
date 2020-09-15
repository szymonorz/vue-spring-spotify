<template>
    <div v-if="this.loaded">
        <vk-grid collapse class="uk-child-width-1-2@s uk-flex-middle" style="height: 500px">
                <div class="uk-background-cover" 
                id="image"
                :style="{'background': 'url('+imgUrl+') no-repeat'}"
                vk-height-viewport="{min-heigh: 500}"
                >
                </div>
                <div>
                    <h1>{{this.artistName}}</h1>
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
                            :key="track['name']">
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
    </div>
</template>

<script>
import {Grid} from "vuikit/lib/grid"
import {Tabs, TabsItem} from "vuikit/lib/tabs"
import vuescroll from "vuescroll"
export default {
    name: 'ArtistInfo',
    components:{
        VkGrid: Grid,
        VkTabs: Tabs,
        VkTabsItem: TabsItem,
        VueScroll: vuescroll,
    },
    data(){
        return{
            artistData: Object,
            artistName: String,
            imgUrl: String,
            token: String,
            genres: Array,
            followers: String,
            topSongs: Array,
            loaded: Boolean,
            ops: {
                vuescroll: {},
                scrollPanel: {},
                rail: {},
                bar: {}
            }
        }
    },
    methods:{
        loadArtistData: function(data)
        {
            this.artistData = data
            this.imgUrl = "'"+data["Artist"]["images"][0]["url"]+"'"
            this.artistName = data["Artist"]["name"]
            this.genres = data["Artist"]["genres"]
            this.followers = data["Artist"]["followers"]["total"]
            this.topSongs = data["Top-Tracks"]["tracks"]
            this.loaded = true
        },
        getArtistInfo: function(id)
        {
            this.$http.get("http://192.168.0.30:8081/artist/"+id)
                .then(resp => this.loadArtistData(resp.data))
                .catch(err => console.log(err))
        }
    },
    mounted(){
        this.token = this.$route.query.token
        this.loaded = false
        this.getArtistInfo(this.$route.params.id)
    }
    
}
</script>
<style scoped>

</style>