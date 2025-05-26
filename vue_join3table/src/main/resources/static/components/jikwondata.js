export default {
    template:`
            <div>
                <h3>직원자료</h3>
                <table v-if="jikwondata.length">
                    <thead>
                        <tr>
                            <th>직원번호</th><th>직원명</th><th>직급</th><th>연봉</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="data in jikwondata" :key="data.jikwonno">
                            <td>{{data.jikwonno}}</td>
                            <td>{{data.jikwonname}}</td>
                            <td>{{data.jikwonjik}}</td>
                            <td>{{data.jikwonpay}}</td>
                        </tr>
                    </tbody>
                </table>
                <p v-else>직원 데이터 조회 실패</p>
            </div>
        `,
    data() {
        return {
            jikwondata:[],
        };
    },
    mounted() {
        axios.get('http://localhost/jikwons')
            .then(Response => {
                this.jikwondata = Response.data;
            })
            .catch(error => {
                console.log('error fetch jikwondata:', error);
            })
    },
}