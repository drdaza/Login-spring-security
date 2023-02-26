<script setup>

</script>

<template>
    <div class="container-login">
        <v-text-field :counter="10" :label="'Username'" required></v-text-field>
        <v-text-field :counter="10" :label="'password'" required></v-text-field>

        
    </div>
    <div class="btn-zone">
        <v-btn :width="'100%'" class="me-4" @click="">
                submit
        </v-btn>
    </div>
</template>
<style lang="scss" scoped>
@use '../assets/sass/main' as *;

.container-login {
    width: 50%;
    @include flexDisplay(column, center, normal);
}
.btn-zone{
    width: 50%;
}
</style>