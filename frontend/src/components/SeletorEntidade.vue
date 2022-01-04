<template>
  <sui-dropdown
    button
    class="icon"
    floating
    icon="world"
    labeled
    :loading="loading"
    :options="listaEntidades"
    text="Selecione a Entidade..."
    v-model="selecionado"
    @input="onChangeEntidade"
  />
</template>

<script>
import api from '@/services/api'

export default {
  name: 'SeletorEntidade',
  data() {
    return {
      entidades: [],
      loading: true,
      selecionado: null,
    };
  },
  mounted() {
    this.loadEntidades()
  },
  computed: {
    listaEntidades() {
      return this.entidades.map(entidade => {
        return { text: entidade.nome, value: entidade.id };
      });
    },
  },
  methods: {
    async loadEntidades() {
      try {
        this.loading = true;
        const response = await api.doRequest('/entidade', 'GET');
        if(response.status === 200) {
          this.entidades = response.data;
        }
      } finally {
        this.loading = false;
      }
    },

    onChangeEntidade() {
      this.$emit('onSelecionaEntidade', this.selecionado)
    }
  }
}
</script>
