<template>

    <v-data-table
        :headers="headers"
        :items="onDeliveryInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OnDeliveryInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderId", value: "orderId" },
                { text: "status", value: "status" },
                { text: "address", value: "address" },
            ],
            onDeliveryInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/onDeliveryInfos'))

            temp.data._embedded.onDeliveryInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.onDeliveryInfo = temp.data._embedded.onDeliveryInfos;
        },
        methods: {
        }
    }
</script>

