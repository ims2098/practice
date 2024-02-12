<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Добавление сотрудника</h2>
    <div class="card">
        <div class="card-header">
            <router-link 
                class="btn btn-outline-info float-right"
                to="/person/">Просмотр всех сотрудников
            </router-link>
        </div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label htmlFor="lName">Фамилия</label>
                    <input 
                        v-model="person.lName"
                        type="text"
                        class="form-control"
                        id="lName"
                        name="lName"/>
                </div>
                <div class="form-group">
                  <label htmlFor="fName">Имя</label>
                  <input 
                      v-model="person.fName"
                      type="text"
                      class="form-control"
                      id="fName"
                      name="fName"/>
              </div>
              <div class="form-group">
                <label htmlFor="mName">Отчество</label>
                <input 
                    v-model="person.mName"
                    type="text"
                    class="form-control"
                    id="mName"
                    name="mName"/>
            </div>
                <div class="form-group">
                  <label htmlFor="departmentId">Отдел</label>
                  <select
                      v-model="person.departmentId"
                      id="departmentId"
                      name="departmentId"
                  >
                    <option v-for="department in departments" v-bind:key="department.id" v-bind:value="department.id">{{department.name}}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label htmlFor="professionId">Профессия</label>
                  <select
                      v-model="person.professionId"
                      id="professionId"
                      name="professionId"
                  >
                    <option v-for="profession in professions" v-bind:key="profession.id" v-bind:value="profession.id">{{profession.name}}</option>
                  </select>
                </div>
                <div class="form-group">
                  <label htmlFor="notes">Примечание</label>
                  <textarea 
                      v-model="person.notes"
                      class="form-control"
                      id="notes"
                      rows="3"
                      name="notes"></textarea>
                </div>
                <button 
                    @click="handleSave()"
                    :disabled="isSaving"
                    type="button"
                    class="btn btn-outline-primary mt-3">
                    Добавить сотрудника
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
  name: 'PersonCreate',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      person: {
        fName: '',
        lName: '',
        mName: '',
        notes: '',
        departmentId: '',
        professionId: ''
      },
      departments: [],
      professions: [],
      isSaving:false,
    };
  },
  created(){
    this.fetchDepartmentsList()
    this.fetchProfessionsList()
  },
  methods: {
    handleSave() {
        this.isSaving = true
        axios.post(`${process.env.VUE_APP_API_URL}/person/`, this.person)
          .then(response => {
            Swal.fire({
                icon: 'success',
                title: 'Сотрудник добавлен успешно!',
                showConfirmButton: false,
                timer: 1500
            })
            this.isSaving = false
            this.person.lName = ""
            this.person.fName = ""
            this.person.mName = ""
            this.person.departmentId = ""
            this.person.professionId = ""
            this.person.notes = ""
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
    },
    fetchProfessionsList() {
      axios.get(`${process.env.VUE_APP_API_URL}/profession/getAll`)
        .then(response => {
            this.professions = response.data;
            return response
        })
        .catch(error => {
          return error
        });
    }
  },
};
</script>