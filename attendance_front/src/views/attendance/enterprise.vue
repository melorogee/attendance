<template>
  <a-card :bordered="false">


    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      <a-form layout="inline" @keyup.enter.native="searchQuery">
        <a-row :gutter="24">


<!--          <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">-->
<!--            <a-col :md="6" :sm="24" >-->
<!--                <a-button type="primary"  style="left: 10px" @click="searchQuery" icon="search">查询</a-button>-->
<!--                <a-button type="primary"  @click="searchReset" icon="reload" style="margin-left: 8px;left: 10px">重置</a-button>-->
<!--            </a-col>-->
<!--          </span>-->

        </a-row>
      </a-form>
    </div>

    <!-- table区域-begin -->
    <a-table
      ref="table"
      size="middle"
      rowKey="id"
      :columns="columns"
      :dataSource="dataSource"
      :pagination="ipagination"
      :loading="loading"
      @change="handleTableChange">

    </a-table>
    <!-- table区域-end -->
  </a-card>
</template>

<script>
  import { filterObj } from '@/utils/util';
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'
  import JEllipsis from '@/components/jeecg/JEllipsis'

  export default {
    name: "enterprise",
    mixins:[JeecgListMixin],
    components: {
      JEllipsis
    },
    data () {
      return {
        description: '企业管理',
        // 查询条件
        queryParam: {
          ipInfo:'',
          createTimeRange:[],
          logType:'1',
          keyWord:'',
        },
        tabKey: "1",
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
          },
          {
            title: '企业名称',
            align:"left",
            dataIndex: 'enterprise_name',
            sorter: true
          },
          {
            title: '企业法人',
              align:"left",
              dataIndex: 'enterprise_owner',
              sorter: true
          },
          {
            title: '联系方式',
              align:"left",
              dataIndex: 'enterprise_contact',
              sorter: true
          },
          {
            title: '企业性质',
              align:"left",
              dataIndex: 'enterprise_type',
              sorter: true
          },
          {
            title: '企业的营业执照',
              align:"left",
              dataIndex: 'enterprise_app',
              sorter: true
          },
          {
            title: '企业地址',
              align:"left",
              dataIndex: 'enterprise_address',
              sorter: true
          },
          {
            title: '创建人',
              align:"left",
              dataIndex: 'create_by',
              sorter: true
          }
            ,
            {
                title: '创建时间',
                align:"left",
                dataIndex: 'create_time',
                sorter: true
            },
            {
                title: '修改人',
                align:"left",
                dataIndex: 'modify_by',
                sorter: true
            },
            {
                title: '修改时间',
                align:"left",
                dataIndex: 'modify_time',
                sorter: true
            }
        ],
        // operateColumn:
        // {
        //   title: '操作类型',
        //   dataIndex: 'operateType_dictText',
        //   align:"center",
        // },
        labelCol: {
          xs: { span: 1 },
          sm: { span: 2 },
        },
        wrapperCol: {
          xs: { span: 10 },
          sm: { span: 16 },
        },
        url: {
          list: "/attendance/enterprise/list",
        },
      }
    },
    methods: {
      getQueryParams(){
        console.log(this.queryParam.createTimeRange)
        var param = Object.assign({}, this.queryParam,this.isorter);
        param.field = this.getQueryField();
        param.pageNo = this.ipagination.current;
        param.pageSize = this.ipagination.pageSize;
        delete param.createTimeRange; // 时间参数不传递后台
        return filterObj(param);
      },

      // 重置
      searchReset(){
        var that = this;
        var logType = that.queryParam.logType;
        that.queryParam = {}; //清空查询区域参数
        that.queryParam.logType = logType;
        that.loadData(this.ipagination.current);
      },
      // 日志类型
      callback(key){

        // 动态添加操作类型列
        if (key == 2) {
          this.tabKey = '2';
          this.columns.splice(7, 0, this.operateColumn);
        }else if(this.columns.length == 9)
        {
          this.tabKey = '1';
          this.columns.splice(7,1);
        }

        let that=this;
        that.queryParam.logType=key;
        that.loadData();
      },
      onDateChange: function (value, dateString) {
        console.log(dateString[0],dateString[1]);
        this.queryParam.createTime_begin=dateString[0];
        this.queryParam.createTime_end=dateString[1];
      },
      onDateOk(value) {
        console.log(value);
      },
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>