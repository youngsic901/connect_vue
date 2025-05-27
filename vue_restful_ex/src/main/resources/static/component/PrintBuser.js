export default {
    data() {
      return {
          busers: [],
      }
    },
    methods: {
        fetchBusers() {
            axios.get('/buser')
            .then(response => {
                this.busers = response.data;
            })
            .catch(error => {
                console.log("읽기에러 : " + error);
            })
        }
    },
    created() {
        this.fetchBusers();
    },
    template: `
        <div>
            <h3>부서정보</h3>
            <table border=1>
                <thead>
                    <tr>
                        <th>번호</th><th>부서명</th><th>지역</th><th>전화</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="buser in busers" :key="buser.buserno">
                        <td>{{buser.buserno}}</td>
                        <td>{{buser.busername}}</td>
                        <td>{{buser.buserloc}}</td>
                        <td>{{buser.busertel}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    `
}