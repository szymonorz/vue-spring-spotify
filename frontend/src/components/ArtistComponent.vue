<template>
<div class="artistComp">
    <div class="artist-block">
        <img @click="$emit('get-info', artistId)" height="100px" width="100px" :src="artist['images'][2]['url']"/>
        <div class="artistInfo">
            <div style="text-align: left; border-bottom: 1px solid black; padding: 5px;">{{artist["name"]}} <br><b> Followers: {{artist["followers"]["total"]}}</b></div>

        </div>
    </div>
</div>
</template>
<script>
export default {
    props: ["artist"],
    data(){
        return{
            genres: Array,
            artistId: String
        }
    },
    methods:{
        
    },
    mounted(){
        console.log(this.artist)
        this.genres = this.artist["genres"]
        this.artistId = this.artist["id"]
    }
}
</script>

<style scoped>
.artist-block{
    display: flex;
    flex-direction: row;
    width: 73%;
    padding: 10px;
    border: 1px solid black;
    border-top: none;
}

.artistComp{
    display: flex;
    justify-content: center;
}

.artistInfo{
    width: 100%;
    padding: 20px;
    display: flex;
    flex-direction: column;
    border-left-color: black;
    border-left-width: 10px;
}

.genres{
    padding-top: 5px;
    display: flex;
}
</style>