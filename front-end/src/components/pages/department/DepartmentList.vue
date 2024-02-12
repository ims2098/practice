<template>
  <layout-div>
        <div class="container">
            <h2 class="text-center mt-5 mb-3">Управление отделами</h2>
            <div class="card">
                <div class="card-header">
                    <router-link to="/department/create"
                        class="btn btn-outline-primary"
                        >Создать отдел
                    </router-link>
                </div>
                <div class="card-body">
             
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Название</th>
                                <th>Родительский отдел</th>
                                <th width="240px">Действие</th>
                            </tr>
                        </thead>
                        <tbody>
                             
                            <tr v-for="department in departments" :key="department.id">
                                <td>{{department.name}}</td>
                                <td>{{department.parentDepartment}}</td>
                                <td>
                                    <router-link :to="`/department/show/${department.id}`" class="btn btn-outline-info mx-1">Показать</router-link>
                                    <router-link :to="`/department/edit/${department.id}`" class="btn btn-outline-success mx-1">Изменить</router-link>
                                    <button 
                                        @click="handleDelete(department.id)"
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
  name: 'DepartmentList',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      departments:[]
    };
  },
  created() {
    this.fetchDepartmentsList();
  },
  methods: {
    fetchDepartmentsList() {
      axios.get(`${process.env.VUE_APP_API_URL}/department/getAll`)
        .then(response => {
            this.departments = response.data;
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
                axios.delete(`${process.env.VUE_APP_API_URL}/department/${id}`)
                .then( response => {
                    Swal.fire({
                        icon: 'success',
                        title: 'Отдел удален успешно!',
                        showConfirmButton: false,
                        timer: 1500
                    })
                    this.fetchDepartmentsList();
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