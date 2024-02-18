<template>
  <div class="window">
    <div class="game-body">
      <MenuView v-if="$store.state.router.router_name === 'menu'" />
      <PkIndexView v-else-if="$store.state.router.router_name === 'pk'" />
      <RecordIndexView v-else-if="$store.state.router.router_name=== 'record'" />
      <RecordContentView v-else-if="$store.state.router.router_name === 'record_content'" />
      <RanklistIndexView v-else-if="$store.state.router.router_name === 'ranklist'" />
      <UserBotIndexView v-else-if="$store.state.router.router_name === 'user_bot'" />
    </div>
  </div>
</template>

<script>
import { useStore } from 'vuex'
import MenuView from './views/MenuView.vue'
import PkIndexView from "./views/pk/PkIndexView.vue"
import RecordContentView from "./views/record/RecordContentView.vue"
import RecordIndexView from "./views/record/RecordIndexView.vue"
import RanklistIndexView from "./views/ranklist/RanklistIndexView.vue"
import UserBotIndexView from "./views/user/bot/UserBotIndexView.vue"

export default {
  components: {
    MenuView,
    PkIndexView,
    RecordContentView,
    RecordIndexView,
    RanklistIndexView,
    UserBotIndexView
  },
  setup() {
    const store = useStore();
    const jwt_token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2OTkzOTI1YWUyNzQ0OGNjYjRiYTUwYTlmZTRjYjQwMCIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTcwODIxNjk4NSwiZXhwIjoxNzA5NDI2NTg1fQ.TLYsjR4gTgDsEN6LDJJpNAlGa_LVYevWI-0rqAb2riY";
    if (jwt_token) {
      store.commit("updateToken", jwt_token);
      store.dispatch("getinfo", {
        success() {
          store.commit("updatePullingInfo", false);
        },
        error() {
          store.commit("updatePullingInfo", false);
        }
      })
    } else {
      store.commit("updatePullingInfo", false);
    }
  }
}
</script>

<style scoped>
div.game-body {
  background-image: url("@/assets/images/background.png");
  background-size: cover;
  width: 100%;
  height: 100%;
}

div.window {
  width: 100vw;
  height: 100vh;
}
</style>
