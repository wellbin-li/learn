package com.lwb.learn.spider.practice;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

public class CsdnBlogPageProcessor implements PageProcessor {

    private static String username = "qq_36330643";// 设置csdn用户名m0_37459945,qq_36330643
    private static int size = 0;// 文章数量
    private static int scrapySize = 0;// 实际抓取文章数量
    private static int pages = 1;// 页码
    private static Selectable mainXpath;
    private CsdnBlogDao csdnBlogDao = new CsdnBlogDao();

    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        // 列表页
        if (page.getUrl().regex("https://blog.csdn.net/" + username + "/article/list/[0-9]{1}").match() && page.getHtml().xpath("//div[@class='article-list']").match()) {
            // 添加所有文章页
            page.addTargetRequests(page.getHtml().xpath("//div[@class='article-list']//div[@class='article-item-box csdn-tracking-statistics']//p[@class='content']/a").links()// 限定文章列表获取区域
                    .all());
            mainXpath = page.getHtml().xpath("//div[@class='article-list']");
            pages++;
            page.addTargetRequest("https://blog.csdn.net/" + username + "/article/list/" + pages);

            // 文章页
        } else if (page.getUrl().regex("https://blog.csdn.net/" + username + "/article/details/[0-9]{8}").match()) {
            size++;// 文章数量加1
            // 用CsdnBlog类来存抓取到的数据，方便存入数据库
            int id = Integer.parseInt(page.getUrl().regex("https://blog\\.csdn\\.net/" + username + "/article/details/(\\d+)").get());
            Selectable xpath = mainXpath.xpath("//div[@data-articleid='" + id + "']");
            CsdnBlog csdnBlog = new CsdnBlog();
            // 设置编号
            csdnBlog.setId(id);
            // 设置标题
            csdnBlog.setTitle(xpath.xpath("//h4/a/text()").get().trim());
            // 设置日期
            csdnBlog.setDate(xpath.xpath("//div[@class='info-box d-flex align-content-center']/p/span[@class='date']/text()").get());
            // 设置标签（可以有多个，用,来分割）
            csdnBlog.setTags(xpath.xpath("//h4/a/span/text()").get().trim());
            // 设置类别（可以有多个，用,来分割）
            csdnBlog.setCategory(page.getHtml().xpath("//div[@class='tags-box']//a[@class='tag-link']/text()").get());
            // 设置阅读人数
            csdnBlog.setView(Integer.parseInt(xpath.xpath("//div[@class='info-box d-flex align-content-center']/p/span[@class='read-num']/text()").regex("阅读数：(\\d+)").get()));
            // 设置评论人数
            csdnBlog.setComments(Integer.parseInt(xpath.xpath("//div[@class='info-box d-flex align-content-center']/p/span[@class='read-num']/text()").regex("评论数：(\\d+)").get()));
            // 设置是否原创
            csdnBlog.setCopyright(xpath.xpath("//h4/a/span/text()").get().trim().equals("原") ? 1 : 0);
            String content = page.getHtml().xpath("//div[@class='markdown_views']").get();
            // 设置内容
            //csdnBlog.setContent(content!=null?content:page.getHtml().xpath("//div[@class='htmledit_views']").get());
            // 把对象存入数据库
            if (csdnBlogDao.add(csdnBlog) != -1) {
                scrapySize++;
            }
            // 把对象输出控制台
            System.out.println(csdnBlog);
        }
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("【爬虫开始】请耐心等待一大波数据到你碗里来...");
        startTime = System.currentTimeMillis();
        // 从用户博客首页开始抓，开启5个线程，启动爬虫
        Spider.create(new CsdnBlogPageProcessor()).addUrl("https://blog.csdn.net/" + username + "/article/list/" + pages).thread(5).run();
        endTime = System.currentTimeMillis();
        System.out.println("【爬虫结束】共" + size + "篇文章，实际抓取" + scrapySize + "篇文章，耗时约" + ((endTime - startTime) / 1000) + "秒，已保存到数据库，请查收！");
    }
}
