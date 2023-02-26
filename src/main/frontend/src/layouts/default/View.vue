<template>
  <nav-bar/>
  <main>  
    
    <router-view />
  </main>
</template>

<script setup>
import NavBar from '@/components/navBar.vue';

  //
</script>

<style lang="scss" scoped>
@use '@/assets/sass/main' as *;
  main{
    width: 100%;
    padding-top: 15vh;
    @include flexDisplay(column, normal, center);
  }
</style>
