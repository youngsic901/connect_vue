export default {
    template:`
            <div>
                <h3>부서자료</h3>
                <table v-if="buserData.length">
                    <thead>
                        <tr>
                            <th>부서번호</th><th>부서명</th><th>위치</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="data in buserData" :key="data.buserno">
                            <td>{{data.buserno}}</td>
                            <td>{{data.busername}}</td>
                            <td>{{data.buserloc}}</td>
                        </tr>
                    </tbody>
                </table>
                <p v-else>부서 데이터 조회 실패</p>
            </div>
        `,
    data() {
        return {
            buserData:[],
        };
    },
    mounted() {
        axios.get('http://localhost/busers')
            .then(Response => {
                this.buserData = Response.data;
            })
            .catch(error => {
                console.log('error fetch buserData:', error);
            })
    },
}