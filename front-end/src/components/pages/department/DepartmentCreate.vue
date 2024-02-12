<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Создание отдела</h2>
    <div class="card">
        <div class="card-header">
            <router-link 
                class="btn btn-outline-info float-right"
                to="/department/">Просмотр всех отделов
            </router-link>
        </div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label htmlFor="name">Название</label>
                    <input 
                        v-model="department.name"
                        type="text"
                        class="form-control"
                        id="name"
                        name="name"/>
                </div>
                <div class="form-group">
                    <label htmlFor="parentDepartmentId">Родительский отдел</label>
                    <select
                        v-model="department.parentDepartmentId"
                        id="parentDepartmentId"
                        name="parentDepartmentId"
                    >
                      <option v-for="departmentP in departments" v-bind:key="departmentP.id" v-bind:value="departmentP.id">{{departmentP.name}}</option>
                    </select>
                </div>
                <button 
                    @click="handleSave()"
                    :disabled="isSaving"
                    type="button"
                    class="btn btn-outline-primary mt-3">
                    Сохранить отдел
                </button>
            </form>
        </div>
    </div>
  </layout-div>
</template>
 
<script>
import axios from 'axios';
import LayoutDiv from '../../LayoutDiv.vue';
import Swal from 'sweetalert2'
 
export default {
  name: 'DepartmentCreate',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      department: {
        name: '',
        parentDepartmentId: ''
      },
      departments: [],
      isSaving:false,
    };
  },
  created(){
    this.fetchDepartmentsList();
  },
  methods: {
    handleSave() {
        this.isSaving = true
        axios.post(`${process.env.VUE_APP_API_URL}/department/`, this.department)
          .then(response => {
            Swal.fire({
                icon: 'success',
                title: 'Отдел создан успешно!',
                showConfirmButton: false,
                timer: 1500
            })
            this.isSaving = false
            this.department.name = ""
            this.department.parentDepartmentId = ""
            this.fetchDepartmentsList()
            return response
          })
          .catch(error => {
            this.isSaving = false
            Swal.fire({
                icon: 'error',
                title: 'Произошла ошибка!',
                showConfirmButton: false,
                timer: 1500
            })
            return error
          });
    },
    fetchDepartmentsList(){
      axios.get(`${process.env.VUE_APP_API_URL}/department/getAll`)
        .then(response => {
            this.departments = response.data;
            return response
        })
        .catch(error => {
          return error
        });
    }
  },
};
</script>