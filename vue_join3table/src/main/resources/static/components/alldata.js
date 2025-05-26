export default {
    template:`
            <div>
                <h3>전체자료</h3>
                <table v-if="allData.length">
                    <thead>
                        <tr>
                            <th>부서번호</th><th>부서명</th><th>직원명</th><th>고객명</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="data in allData" :key="data.jikwonno">
                            <td>{{data.buserno}}</td>
                            <td>{{data.busername}}</td>
                            <td>{{data.jikwonname}}</td>
                            <td>{{data.gogekname}}</td>
                        </tr>
                    </tbody>
                </table>
                <p v-else>전체 데이터 조회 실패</p>
            </div>
        `,
    data() {
        return {
            allData:[],
        };
    },
    mounted() {
        axios.get('http://localhost/joindata')
            .then(Response => {
                this.allData = Response.data;
            })
            .catch(error => {
                console.log('error fetch data:', error);
            })
    },
}