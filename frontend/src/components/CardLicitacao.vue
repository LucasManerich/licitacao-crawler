<template>
  <sui-card class="fluid" v-bind:class="{ lido: isLido }">
    <sui-card-content>
      <sui-card-header>{{ numeroAno }} - {{ tituloModalidade }}</sui-card-header>
      <sui-card-meta>{{ dataAbertura }}</sui-card-meta>
      <sui-card-description>
        <p>
          {{ objeto }}
        </p>
      </sui-card-description>
    </sui-card-content>
    <sui-card-content extra>
      <sui-button icon="check" v-if="!isLido" @click="setLido">Marcar como lido</sui-button>
      <sui-button icon="close" v-if="isLido" @click="removeLido">Marcar como não lido</sui-button>
    </sui-card-content>
  </sui-card>
</template>

<script>
import Modalidade from '@/enum/ModalidadeLicitacao'

export default {
  name: 'CardLicitacao',
  props: ['objeto', 'numero', 'ano', 'modalidade', 'dataAbertura', 'entidade'],
  computed: {
    numeroAno() {
      return `${this.numero}/${this.ano}`
    },
    tituloModalidade() {
      return Modalidade[this.modalidade]
    },
    chaveStorage() {
      return `lido_${this.numero}_${this.ano}_${this.entidade}`;
    }
  },
  data() {
    return {
      isLido: false,
    }
  },
  mounted() {
    this.loadLido()
  },
  methods: {
    loadLido() {
      if(localStorage.getItem(this.chaveStorage)) {
        this.isLido = true
      }
    },
    setLido() {
      this.isLido = true;
      localStorage.setItem(this.chaveStorage, true)
    },
    removeLido() {
      this.isLido = false;
      localStorage.removeItem(this.chaveStorage)
    }
  }
}
</script>

<style scoped>
  .lido {
    background-color: #f3f3f3!important;
  }
</style>