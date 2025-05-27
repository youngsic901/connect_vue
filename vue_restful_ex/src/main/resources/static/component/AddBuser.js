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
        addBuser() {
            axios.post(`/buser`, this.buser)
            .then(() => {
                alert("부서 추가 성공")
                this.$router.push('/')
            })
            .catch(error => {
                console.log("추가 오류 : " + error);
            })
        }
    },
    template:`
        <div>
            <h3>부서 추가</h3>
            <form @submit.prevent="addBuser">
                번호 : <input v-model="buser.buserno" required /><br>
                부서명 : <input v-model="buser.busername" required /><br>
                지역 : <input v-model="buser.buserloc" required /><br>
                전화 : <input v-model="buser.busertel" required /><br>
                <button type="submit">추가</button>
            </form>
        </div>
    `
}