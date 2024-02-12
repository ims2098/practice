<template>
  <layout-div>
        <div class="container">
            <h2 class="text-center mt-5 mb-3">Управление сотрудниками</h2>
            <div class="card">
                <div class="card-header">
                    <router-link to="/person/create"
                        class="btn btn-outline-primary"
                        >Добавить сотрудника
                    </router-link>
                </div>
                <div class="card-body">
             
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Фамилия</th>
                                <th>Имя</th>
                                <th>Отчество</th>
                                <th>Профессия</th>
                                <th>Отдел</th>
                                <th>Примечания</th>
                                <th width="240px">Действие</th>
                            </tr>
                        </thead>
                        <tbody>
                             
                            <tr v-for="person in persons" :key="person.id">
                                <td>{{person.lName}}</td>
                                <td>{{person.fName}}</td>
                                <td>{{person.mName}}</td>
                                <td>{{person.profession}}</td>
                                <td>{{person.department}}</td>
                                <td>{{person.notes}}</td>
                                <td>
                                    <router-link :to="`/person/show/${person.id}`" class="btn btn-outline-info mx-1">Показать</router-link>
                                    <router-link :to="`/person/edit/${person.id}`" class="btn btn-outline-success mx-1">Изменить</router-link>
                                    <button 
                                        @click="handleDelete(person.id)"
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
  name: 'PersonList',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      persons:[]
    };
  },
  created() {
    this.fetchPersonsList();
  },
  methods: {
    fetchPersonsList() {
      axios.get(`${process.env.VUE_APP_API_URL}/person/getAll`)
        .then(response => {
            this.persons = response.data;
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
                axios.delete(`${process.env.VUE_APP_API_URL}/person/${id}`)
                .then( response => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Сотрудник удален успешно!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    this.fetchPersonsList();
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