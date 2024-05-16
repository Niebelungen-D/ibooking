<template>
    <div id="index">
        <div class="jumbotron">
            <h1>自习室预约系统</h1>
            <p>欢迎使用自习室预约系统</p>
            <!--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
            <router-link :user="User" to="/all_studyrooms" class="btn btn-primary" role="button">自习室查看</router-link>
            
        </div>
    </div>
</template>