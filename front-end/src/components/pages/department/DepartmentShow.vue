<template>
   <layout-div>
        <h2 class="text-center mt-5 mb-3">Показать отдел</h2>
        <div class="card">
            <div class="card-header">
                <router-link 
                    class="btn btn-outline-info float-right"
                    to="/department/">Просмотр всех отделов
                </router-link>
            </div>
            <div class="card-body">
                <b className="text-muted">Название:</b>
                <p>{{department.name}}</p>
                <b className="text-muted">Родительский отдел:</b>
                <p>{{department.parentDepartment}}</p>
            </div>
        </div>
   </layout-div>
</template>
 
<script>
import axios from 'axios';
import LayoutDiv from '../../LayoutDiv.vue';
import Swal from 'sweetalert2'
 
export default {
  name: 'DepartmentShow',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      department: {
        name: '',
        parentDepartment: ''
      },
      isSaving:false,
    };
  },
  created() {
    const id = this.$route.params.id;
    axios.get(`${process.env.VUE_APP_API_URL}/department/get/${id}`)
    .then(response => {
        let departmentInfo = response.data
        this.department.name = departmentInfo.name
        this.department.parentDepartment = departmentInfo.parentDepartment
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