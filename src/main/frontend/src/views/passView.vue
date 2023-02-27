<script setup>
import axios from 'axios';

const functionTest = async () =>{
    const responser = await axios.get('http://localhost:8080/api/products');

    console.log(responser);
}

functionTest()
</script>
<template>
    <div>
        <h1>bienvenido</h1>
    </div>
</template>