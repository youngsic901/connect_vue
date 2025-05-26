export default {
    template:`
            <div>
                <h3>고객자료</h3>
                <table v-if="gogekData.length">
                    <thead>
                        <tr>
                            <th>고객번호</th><th>고객명</th><th>전화번호</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="data in gogekData" :key="data.gogekno">
                            <td>{{data.gogekno}}</td>
                            <td>{{data.gogekname}}</td>
                            <td>{{data.gogektel}}</td>
                        </tr>
                    </tbody>
                </table>
                <p v-else>고객 데이터 조회 실패</p>
            </div>
        `,
    data() {
        return {
            gogekData:[],
        };
    },
    mounted() {
        axios.get('http://localhost/gogeks')
            .then(Response => {
                this.gogekData = Response.data;
            })
            .catch(error => {
                console.log('error fetch gogekData:', error);
            })
    },
}