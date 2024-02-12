<template>
   <layout-div>
        <h2 class="text-center mt-5 mb-3">Просмотр Сотрудника</h2>
        <div class="card">
            <div class="card-header">
                <router-link 
                    class="btn btn-outline-info float-right"
                    to="/person/">Просмотр всех сотрудников
                </router-link>
            </div>
            <div class="card-body">
                <b className="text-muted">Фамилия:</b>
                <p>{{person.lName}}</p>
                <b className="text-muted">Имя:</b>
                <p>{{person.fName}}</p>
                <b className="text-muted">Отчество:</b>
                <p>{{person.mName}}</p>
                <b className="text-muted">Отдел:</b>
                <p>{{person.department}}</p>
                <b className="text-muted">Профессия:</b>
                <p>{{person.profession}}</p>
                <b className="text-muted">Примечание:</b>
                <p>{{person.notes}}</p>
            </div>
        </div>
   </layout-div>
</template>
 
<script>
import axios from 'axios';
import LayoutDiv from '../../LayoutDiv.vue';
import Swal from 'sweetalert2'
 
export default {
  name: 'PersonShow',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      person: {
        fName: '',
        lNotes: '',
        mName: '',
        notes: '',
        department: '',
        profession: '',
      },
      isSaving:false,
    };
  },
  created() {
    const id = this.$route.params.id;
    axios.get(`${process.env.VUE_APP_API_URL}/person/get/${id}`)
    .then(response => {
        let personInfo = response.data
        this.person.fName = personInfo.fName
        this.person.lName = personInfo.lName
        this.person.mName = personInfo.mName
        this.person.department = personInfo.department
        this.person.profession = personInfo.profession
        this.person.notes = personInfo.notes
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