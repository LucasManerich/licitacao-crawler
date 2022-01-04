<template>
  <div id="app">
    <sui-container>
      <sui-segment>
        <seletor-entidade @onSelecionaEntidade="onSelecionaEntidade"></seletor-entidade>
        <sui-divider />
        <sui-dimmer :active="loading" inverted>
          <sui-loader></sui-loader>
        </sui-dimmer>
        <card-licitacao 
          v-for="licitacao of licitacoes" 
          :key="licitacao.numero + '/' + licitacao.ano"
          :entidade="idEntidade"
          :numero="licitacao.numero"
          :ano="licitacao.ano"
          :modalidade="licitacao.modalidade"
          :objeto="licitacao.objeto"
          :dataAbertura="licitacao.dataAbertura"
        ></card-licitacao>
      </sui-segment>
    </sui-container>
  </div>
</template>

<script>
import CardLicitacao from './components/CardLicitacao.vue'
import SeletorEntidade from './components/SeletorEntidade.vue'
import api from '@/services/api'

export default {
  name: 'App',
  components: {
    SeletorEntidade,
    CardLicitacao
  },
  data() {
    return {
      loading: false,
      idEntidade: null,
      licitacoes: []
    }
  },
  methods: {
    async onSelecionaEntidade(idEntidade) {
      try {
        this.loading = true;
        this.idEntidade = idEntidade;

        const response = await api.doRequest(`/licitacao/${idEntidade}`)
        if(response.status == 200) {
          this.licitacoes = response.data;
        }
      } finally {
        this.loading = false
      }
    }
  }
}
</script>

<style scoped>
  #app {
    margin-top: 40px
  }
</style>