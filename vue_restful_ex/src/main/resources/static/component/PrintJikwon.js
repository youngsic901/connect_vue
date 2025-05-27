export default {
    data() {
        return {
            jikwons: [],
        }
    },
    methods: {
        fetchJikwons() {
            axios.get('/jikwon')
                .then(response => {
                    this.jikwons = response.data;
                })
                .catch(error => {
                    console.log("읽기에러 : " + error);
                })
        }
    },
    created() {
        this.fetchJikwons();
    },
    template: `
        <div>
            <h3>직원정보</h3>
            <table border=1>
                <thead>
                    <tr>
                        <th>사번</th><th>직원명</th><th>직급</th><th>부서</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="jikwon in jikwons" :key="jikwon.buserno">
                        <td>{{jikwon.jikwonno}}</td>
                        <td>{{jikwon.jikwonname}}</td>
                        <td>{{jikwon.jikwonjik}}</td>
                        <td>{{jikwon.buser.busername}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    `
}