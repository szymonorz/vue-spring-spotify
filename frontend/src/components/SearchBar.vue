<template>
    <div id="searchBar">
        <form v-on:submit="onSubmit">
            <input type="text" placeholder="Wpisz artystę" id="search" v-model="artistName"/>
            
        </form>
        <ArtistComponent
            v-for="artist in result"
            :key="artist"
            :artist="artist"
            v-on:get-info="$emit('get-info', $event)"
             />
    </div>
</template>
<script>
import ArtistComponent from "./ArtistComponent"
export default {
    components:{
        ArtistComponent
    },
    props: ["token"],
    data(){
        return{
            artistName: '',
            result: []
        }
    },
    methods:{
        onSubmit: function(e)
        {
            e.preventDefault();
            this.$http.request({
                url: "/search/"+this.artistName,
                method: 'get',
                baseURL: "http://192.168.0.30:8081"
            })
            .then(response => this.result = response.data["items"])
            .catch(err => console.log(err))
            
        }
        
    }
}
</script>
<style scoped>
#search{
    width: 70%;
    padding: 25px;
}

#searchBar{
    display:flex;
    flex-direction: column;
    justify-content: center;

}
</style>