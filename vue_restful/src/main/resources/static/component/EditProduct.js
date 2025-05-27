export default {
    template:`
        <div>
            <h2>제품 수정</h2>
            <form @submit.prevent="updateProduct">
                코드 : <input v-model="product.code" disabled /><br>
                이름 : <input v-model="product.name" required /><br>
                설명 : <input v-model="product.description" required /><br>
                가격 : <input v-model="product.price" type="number" required /><br>
                <button type="submit">수정 확인</button>
            </form>
        </div>
    `,
    data() {
        return {
            product: {
                code: '',
                name: '',
                description: '',
                price: null,
            }
        };
    },
    methods: {
        fetchProduct() {
            axios.get(`/products/${this.$route.params.code}`)
            .then(response => {
                this.product = response.data;
            })
            .catch(error => {
                console.log('읽기 오류 : ', error);
            })
        },
        updateProduct(product) {
            axios.put(`/products/${this.product.code}`, this.product)
            .then(() => {
                alert('상품 수정 성공')
                this.$router.push('/')
            })
            .catch(error => {
                console.log('수정 오류 : ',error);
            })
        },
    },
    created() {
        this.fetchProduct();
    }
}