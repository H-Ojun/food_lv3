<template>

    <v-data-table
        :headers="headers"
        :items="payInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PayInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderId", value: "orderId" },
                { text: "cancel", value: "cancel" },
            ],
            payInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/payInfos'))

            temp.data._embedded.payInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.payInfo = temp.data._embedded.payInfos;
        },
        methods: {
        }
    }
</script>

