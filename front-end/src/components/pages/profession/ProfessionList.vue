
<template>
  <layout-div>
        <div class="container">
            <h2 class="text-center mt-5 mb-3">Управление профессиями</h2>
            <div class="card">
                <div class="card-header">
                    <router-link to="/profession/create"
                        class="btn btn-outline-primary"
                        >Добавить профессию
                    </router-link>
                </div>
                <div class="card-body">
             
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Название</th>
                                <th>Примечания</th>
                                <th width="240px">Действие</th>
                            </tr>
                        </thead>
                        <tbody>
                             
                            <tr v-for="profession in professions" :key="profession.id">
                                <td>{{profession.name}}</td>
                                <td>{{profession.notes}}</td>
                                <td>
                                    <router-link :to="`/profession/show/${profession.id}`" class="btn btn-outline-info mx-1">Показать</router-link>
                                    <router-link :to="`/profession/edit/${profession.id}`" class="btn btn-outline-success mx-1">Изменить</router-link>
                                    <button 
                                        @click="handleDelete(profession.id)"
                                        className="btn btn-outline-danger mx-1">
                                        Удалить
                                    </button>
                                </td>
                            </tr>
                                 
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </layout-div>
</template>
 
 
<script>
import axios from 'axios';
import LayoutDiv from '../../LayoutDiv.vue';
import Swal from 'sweetalert2'
 
export default {
  name: 'ProfessionList',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      professions:[]
    };
  },
  created() {
    this.fetchProfessionsList();
  },
  methods: {
    fetchProfessionsList() {
      axios.get(`${process.env.VUE_APP_API_URL}/profession/getAll`)
        .then(response => {
            this.professions = response.data;
            return response
        })
        .catch(error => {
          return error
        });
    },
    handleDelete(id){
        Swal.fire({
            title: 'Вы уверены?',
            text: "Это действие необратимо!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Да!'
          }).then((result) => {
            if (result.isConfirmed) {
                axios.delete(`${process.env.VUE_APP_API_URL}/profession/${id}`)
                .then( response => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Профессия удалена успешно!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    this.fetchProfessionsList();
                    return response
                })
                .catch(error => {
                    Swal.fire({
                         icon: 'error',
                        title: 'Произошла ошибка!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    return error
                });
            }
          })
    }
  },
};
</script>