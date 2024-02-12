<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <router-link to="/profession" class="navbar-brand">Управление профессиями</router-link>
        <router-link to="/department" class="navbar-brand">Управление отделами</router-link>
        <router-link to="/person" class="navbar-brand">Управление сотрудниками</router-link>        
      </div>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>
 
<script>
export default {
  name: 'App',
};
</script>