<template>
    <div id="button">
        <a href="http://192.168.0.30:8081/hello">{{msg}}</a>
    </div>
</template>
<script>
export default {
    props:["msg"]    
}
</script>
<style scoped>
#button
{
    background-color: #3333ff;
    color: white;
    padding: 10px;
}
a{
    text-decoration: none;
    color: white;
}
</style>