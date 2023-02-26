<script setup>
import { reactive } from 'vue';
import { useAppStore } from '@/store/app';
import UserPayLoad from '@/apiCall/payloads/UserPayLoad';

const test = useAppStore();
const data = reactive(new UserPayLoad('', ''));


const submit = () => {
    console.log(data.username);
    console.log(data.password);
    test.login(data.username, data.password);
}

</script>

<template>
    <div class="container-login">
        <v-text-field v-model="data.username" :counter="10" :label="'Username'" required></v-text-field>
        <v-text-field v-model="data.password" :counter="10" :label="'password'" required></v-text-field>

        
    </div>
    <div class="btn-zone">
        <v-btn :width="'100%'" class="me-4" @click="submit()">
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