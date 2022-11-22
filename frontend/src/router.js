
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderListManager from "./components/listers/OrderListCards"
import OrderListDetail from "./components/listers/OrderListDetail"
import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import PayInfoView from "./components/PayInfoView"
import PayInfoViewDetail from "./components/PayInfoViewDetail"
import FoodCookingManager from "./components/listers/FoodCookingCards"
import FoodCookingDetail from "./components/listers/FoodCookingDetail"

import DeliveryManager from "./components/listers/DeliveryCards"
import DeliveryDetail from "./components/listers/DeliveryDetail"

import OnDeliveryInfoView from "./components/OnDeliveryInfoView"
import OnDeliveryInfoViewDetail from "./components/OnDeliveryInfoViewDetail"
import OrderStatusManager from "./components/listers/OrderStatusCards"
import OrderStatusDetail from "./components/listers/OrderStatusDetail"

import SearchView from "./components/SearchView"
import SearchViewDetail from "./components/SearchViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderLists',
                name: 'OrderListManager',
                component: OrderListManager
            },
            {
                path: '/orderLists/:id',
                name: 'OrderListDetail',
                component: OrderListDetail
            },
            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/payInfos',
                name: 'PayInfoView',
                component: PayInfoView
            },
            {
                path: '/payInfos/:id',
                name: 'PayInfoViewDetail',
                component: PayInfoViewDetail
            },
            {
                path: '/foodCookings',
                name: 'FoodCookingManager',
                component: FoodCookingManager
            },
            {
                path: '/foodCookings/:id',
                name: 'FoodCookingDetail',
                component: FoodCookingDetail
            },

            {
                path: '/deliveries',
                name: 'DeliveryManager',
                component: DeliveryManager
            },
            {
                path: '/deliveries/:id',
                name: 'DeliveryDetail',
                component: DeliveryDetail
            },

            {
                path: '/onDeliveryInfos',
                name: 'OnDeliveryInfoView',
                component: OnDeliveryInfoView
            },
            {
                path: '/onDeliveryInfos/:id',
                name: 'OnDeliveryInfoViewDetail',
                component: OnDeliveryInfoViewDetail
            },
            {
                path: '/orderStatuses',
                name: 'OrderStatusManager',
                component: OrderStatusManager
            },
            {
                path: '/orderStatuses/:id',
                name: 'OrderStatusDetail',
                component: OrderStatusDetail
            },

            {
                path: '/searches',
                name: 'SearchView',
                component: SearchView
            },
            {
                path: '/searches/:id',
                name: 'SearchViewDetail',
                component: SearchViewDetail
            },


    ]
})
