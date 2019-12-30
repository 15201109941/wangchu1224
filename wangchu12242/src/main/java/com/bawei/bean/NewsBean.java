package com.bawei.bean;

import java.util.List;

/*
 *@auther:王楚
 *@Date: 2019/12/24
 *@Time:13:55
 *@Description:${DESCRIPTION}
 **/
public class NewsBean {
    /**
     * code : 200
     * message : 鎴愬姛!
     * category : [{"clazz":"1611A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編8"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編9"}]},{"clazz":"1611B","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忔槑8"}]},{"clazz":"1612A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"寮犱笁8"}]},{"clazz":"1612B","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鏉庡洓8"}]},{"clazz":"1613A","childs":[{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"鐜嬩簲8"}]}]
     */

    private int code;
    private String message;
    private List<CategoryBean> category;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        /**
         * clazz : 1611A
         * childs : [{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編1"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編2"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編3"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編4"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編5"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編6"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編7"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編8"},{"avatar":"http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg","name":"灏忕編9"}]
         */

        private String clazz;
        private List<ChildsBean> childs;

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
        }

        public static class ChildsBean {
            /**
             * avatar : http://blog.zhaoliang5156.cn/api/images/head_zhu_2019_08_01.jpeg
             * name : 灏忕編1
             */

            private String avatar;
            private String name;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
