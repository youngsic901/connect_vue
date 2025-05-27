export default {
    data() {
        return {
            buser: {
                buserno: null,
                busername: '',
                buserloc: '',
                busertel: '',
            }
        };
    },
    methods: {
        updateBuser() {
            axios.put(`/buser/updatebuser/${this.buser.buserno}`, this.buser)
            .then(() => {
                alert("부서 수정 성공")
                this.$router.push('/')
            })
            .catch(error => {
                console.log("수정 오류 : " + error);
            })
        },
        fetchBusers() {
            axios.get(`/buser/${this.$route.params.buserno}`)
                .then(response => {
                    this.buser = response.data;
                })
                .catch(error => {
                    console.log('읽기 오류 :  ' + error);
                })
        }
    },
    created() {
        this.fetchBusers();
    },
    template: `
        <div>
            <h3>부서 수정</h3>
            <form @submit.prevent="updateBuser">
                번호 : <input v-model="buser.buserno" required /><br>
                부서명 : <input v-model="buser.busername" required /><br>
                지역 : <input v-model="buser.buserloc" required /><br>
                전화 : <input v-model="buser.busertel" required /><br>
                <button type="submit">수정</button>
            </form>
        </div>
    `
}