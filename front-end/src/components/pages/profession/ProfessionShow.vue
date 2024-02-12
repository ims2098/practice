<template>
   <layout-div>
        <h2 class="text-center mt-5 mb-3">Показать профессию</h2>
        <div class="card">
            <div class="card-header">
                <router-link 
                    class="btn btn-outline-info float-right"
                    to="/profession/">Просмотр всех профессий
                </router-link>
            </div>
            <div class="card-body">
                <b className="text-muted">Название:</b>
                <p>{{profession.name}}</p>
                <b className="text-muted">Примечание:</b>
                <p>{{profession.notes}}</p>
            </div>
        </div>
   </layout-div>
</template>
 
<script>
import axios from 'axios';
import LayoutDiv from '../../LayoutDiv.vue';
import Swal from 'sweetalert2'
 
export default {
  name: 'ProfessionShow',
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
  created() {
    const id = this.$route.params.id;
    axios.get(`${process.env.VUE_APP_API_URL}/profession/get/${id}`)
    .then(response => {
        let professionInfo = response.data
        this.profession.name = professionInfo.name
        this.profession.notes = professionInfo.notes
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
    })
  },
  methods: {
     
  },
};
</script>