<template>

    <v-data-table
        :headers="headers"
        :items="search"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "status", value: "status" },
                { text: "orderId", value: "orderId" },
            ],
            search : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/searches'))

            temp.data._embedded.searches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.search = temp.data._embedded.searches;
        },
        methods: {
        }
    }
</script>

