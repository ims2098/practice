<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Создание профессии</h2>
    <div class="card">
        <div class="card-header">
            <router-link 
                class="btn btn-outline-info float-right"
                to="/profession/">Просмотр всех профессий
            </router-link>
        </div>
        <div class="card-body">
            <form>
                <div class="form-group">
                    <label htmlFor="name">Название</label>
                    <input 
                        v-model="profession.name"
                        type="text"
                        class="form-control"
                        id="name"
                        name="name"/>
                </div>
                <div class="form-group">
                    <label htmlFor="notes">Примечание</label>
                    <textarea 
                        v-model="profession.notes"
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
                    Сохранить профессию
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
  name: 'ProfessionCreate',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      profession: {
        name: '',
        notes: ''
      },
      isSaving:false,
    };
  },
  methods: {
    handleSave() {
        this.isSaving = true
        axios.post(`${process.env.VUE_APP_API_URL}/profession/`, this.profession)
          .then(response => {
            Swal.fire({
                icon: 'success',
                title: 'Профессия создана успешно!',
                showConfirmButton: false,
                timer: 1500
            })
            this.isSaving = false
            this.profession.name = ""
            this.profession.notes = ""
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
  },
};
</script>