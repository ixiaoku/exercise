/*package sql;

import redis.clients.jedis.*;

import java.util.HashMap;
import java.util.Map;

public class JedisDemo {
    private static final JedisPool JEDIS_POOL;

    static {
        JedisPoolConfig config = new JedisPoolConfig();//redis���ӳ����ö���
        config.setMaxTotal(32);//���������
        config.setMaxIdle(6);//�������������
        config.setMinIdle(0);//������С������
        config.setMaxWaitMillis(15000);//��������������󣬵���������ʱ��
        config.setMinEvictableIdleTimeMillis(300000);//���ӿ��е���Сʱ�䣬���ܱ��Ƴ�
        config.setSoftMinEvictableIdleTimeMillis(-1);//���ӿ��е���Сʱ�䣬������С�������ӵĽ����Ƴ�
        config.setNumTestsPerEvictionRun(3);//����ÿ�μ�����õĸ���
        config.setTestOnBorrow(false);//��������ʱ���Ƿ���������Ч
        config.setTestOnReturn(false);//��������ʱ���Ƿ���������Ч
        config.setTestWhileIdle(false);//���г�ʱ,�Ƿ�ִ�м����Ч
        config.setTimeBetweenEvictionRunsMillis(60000);//���м��ʱ��
        config.setBlockWhenExhausted(true);//���������ľ����Ƿ�����

        //���ӳ����ö���+ip+port+timeout+password+dbname
        JEDIS_POOL = new JedisPool(config,"127.0.0.1",6379,15000,null,1);
    }

    *//**
     * redis��String���Ͳ������ַ���+����+bit
     *//*
    public static void stringCmdTest(Jedis jedis){
        System.out.println("----------------redis-String-----------------");
        //set:���ز������
        System.out.println("name=>wsy:"+jedis.set("name","wsy"));

        //get:value
        System.out.println("name:"+jedis.get("name"));

        //append:�ַ�������
        System.out.println("append:"+jedis.append("name","_ss"));

        //strlen:�ַ�������
        System.out.println("strlen:"+jedis.strlen("name"));

        //getrange:���ز�������ʼ�����ֵ
        System.out.println("getrange:"+jedis.getrange("name", 10, 13));

        //setrange:����ʼ���꿼���滻��δ�滻�ı���
        System.out.println("setrange:"+jedis.setrange("name", 10, "#"));

        //mset:�������ã������������ý��
        System.out.println("mset:"+jedis.mset("name","wsy","age", "29"));

        //mget:��������
        System.out.println("mget:"+jedis.mget("name","age"));

        //incr:value����1�󣬷���value
        System.out.println("incr:"+jedis.incr("age"));

        //incr:value��������ֵ�󣬷���value
        System.out.println("incrBy:"+jedis.incrBy("age",3));

        //decr:value�Լ�1������value
        System.out.println("decr:"+jedis.decr("age"));

        //decrBy:value�Լ����ֵ������value
        System.out.println("decrBy:"+jedis.decrBy("age",3));

        //setex:����keyֵ+��Чʱ�䣬���key�����򸲸�value
        System.out.println("setex:"+jedis.setex("phone",10,"13600000001"));

        //setnx:��key������ʱ�����òųɹ�
        System.out.println("setnx:"+jedis.setnx("address","china"));

        //del:ɾ����Ӧkey
        System.out.println("del:"+jedis.del("address1"));

        System.out.println("----------------redis-String-----------------\n");

    }

    *//**
     * redis��hash���ͳ��ò���
     * @param jedis
     *//*
    public static void hashMapCmdTest(Jedis jedis){
        System.out.println("----------------redis-HashMap-----------------");
        //hset:����ֵΪkeyΪ�·���1��Ϊ�ɸ��Ǿ�ֵ����0
        System.out.println("hset:"+jedis.hset("user","name","wangshaoyi"));

        Map map = new HashMap();
        map.put("name","wsy");
        map.put("age","29");
        //hmset:map����
        System.out.println("hmset:" + jedis.hmset("user", map));

        //hexists:�ж�hashmap��key�Ƿ����
        System.out.println("hexists:"+jedis.hexists("user","age"));

        //hget:��ȡmap��key��Ӧ��value
        System.out.println("hget:"+jedis.hget("user","name"));

        //hgetAll:��ȡmap�����ж���
        System.out.println("hgetAll:"+jedis.hgetAll("user"));

        //hkeys:��ȡmap������key
        System.out.println("hkeys:"+jedis.hkeys("user"));

        //hvals:��ȡmap������value
        System.out.println("hvals:"+jedis.hvals("user"));


        //hmget:������ȡkeys�Ķ��󣬷���List
        System.out.println("hmget:"+jedis.hmget("user","age","name"));

        //hlen:map�Ĵ�С
        System.out.println("hlen:"+jedis.hlen("user"));

        //hdel:ɾ��map�ж�Ӧkey,��ȷɾ������1
        System.out.println("hdel:"+jedis.hdel("user","age0"));

        System.out.println("----------------redis-HashMap-----------------\n");

    }

    public static void listCmdTest(Jedis jedis){
        System.out.println("----------------redis-List-----------------");
        //
        jedis.del("contacts");
        jedis.del("contacts_old");


        //lpush:����ͷ�����룬����List��size
        System.out.println("lpush:"+jedis.lpush("contacts","xx","yy","zz"));

        //lpushx:����ͷ�����룬����List��size
        System.out.println("lpushx:"+jedis.lpushx("contacts","aa"));

        //linsert:ָ������λ��(ǰor��)����
        System.out.println("linsert:"+jedis.linsert("contacts", BinaryClient.LIST_POSITION.BEFORE,"zz","bb"));

        //lset:��ָ����λ������ֵ���滻��ֵ��
        System.out.println("lset:"+jedis.lset("contacts",2,"cc"));

        //lpop:����ͷ�Ķ���
        System.out.println("lpop:"+jedis.lpop("contacts"));

        //lrange:��ȡlistָ��start��endλ��value
        System.out.println("lrange:"+jedis.lrange("contacts",1,3));

        //ltrim:ֻʣstart\end��listֵ������ɾ��
        System.out.println("ltrim:"+jedis.ltrim("contacts",1,3));

        //lrem:ɾ��listָ��ֵ������ָ����������ɾ������
        System.out.println("lrem:"+jedis.lrem("contacts",2,"yy"));

        //rpoplpush:��Դlistβ�������Ƶ�Ŀ��list����ͷ��
        System.out.println("rpoplpush:"+jedis.rpoplpush("contacts","contacts_old"));

        //rpush:��listβ���������ֵ
        System.out.println("rpush:"+jedis.rpush("contacts","aa","bb"));

        //rpop:�Ƴ���listβ��ֵ�������Ƴ��Ķ���
        System.out.println("rpop:"+jedis.rpop("contacts"));

        //brpop:����β�������׳���ָ����ʱʱ�䣬�����׳�ֵ
        System.out.println("brpop:"+jedis.brpop(1,"contacts"));

        System.out.println("blpop:"+jedis.blpop(1, "contacts"));

        System.out.println("blpop������1�뷵�أ�:"+jedis.blpop(1, "contacts"));

        System.out.println("----------------redis-List-----------------\n");


    }

    public static void setCmdTest(Jedis jedis){
        System.out.println("----------------redis-Set-----------------");
        jedis.del("phones");
        jedis.del("phones_old");
        jedis.del("phones_old_1");
        jedis.del("phones_new");


        //sadd:�������Ԫ��,������ӳɹ�������
        System.out.println("sadd:"+jedis.sadd("phones","13600000001","13300000001"));
        System.out.println("sadd:"+jedis.sadd("phones","13600000002","13300000002"));

        //scard:���ؼ�����Ԫ����
        System.out.println("scard:"+jedis.scard("phones"));

        jedis.sadd("phones_old","13600000002");
        jedis.sadd("phones_old_1","13300000001");

        //sdiff:��set������set֮��Ĳ�����زֵ
        System.out.println("sdiff:"+jedis.sdiff("phones","phones_old","phones_old_1"));

        //sdiffstore:��set������set֮��Ĳ��������set�����ز��
        System.out.println("sdiffstore:"+jedis.sdiffstore("phones_new","phones","phones_old"));

        //sinter:���ؼ��ϵĽ���
        System.out.println("sinter:"+jedis.sinter("phones","phones_new"));

        //sismember:�ж�value�Ƿ�Ϊset��ֵ
        System.out.println("sismember:"+jedis.sismember("phones","13600000001"));

        //smembers:���ؼ����г�Ա
        System.out.println("smembers:"+jedis.smembers("phones"));

        //smove:����Դset��Ԫ���ƶ�Ŀ��set�������ƶ���
        System.out.println("smove:"+jedis.smove("phones","phones_new","13600000002"));

        //spop:����Ƴ�set��һԪ�أ������Ƴ�Ԫ��
        System.out.println("spop:"+jedis.spop("phones"));

        //srandmember:���ȡ��������һ��Ԫ��
        System.out.println("srandmember:"+jedis.srandmember("phones_new"));

        //srem:ɾ��������ָ��Ԫ��
        System.out.println("srem:"+jedis.srem("phones_new","13600000002"));

        //sunion:�����в���
        System.out.println("sunion:"+jedis.sunion("phones","phones_new","phones_old"));

        System.out.println("----------------redis-Set-----------------\n");

    }

    public static void sortedSetTest(Jedis jedis){

        System.out.println("----------------redis-SortedSet-----------------");
        jedis.del("scores");
        jedis.del("scores_1");
        jedis.del("scores_total");
        jedis.del("score_inter");
        jedis.del("score_max");



        //zadd:sortedSet���Ԫ��
        System.out.println("zadd:"+jedis.zadd("scores", 610.5, "xx"));
        jedis.zadd("scores", 630, "yy");

        //zcard:����sortedset��Ԫ����
        System.out.println("zcard:"+jedis.zcard("scores"));

        //zcount:����ָ����ֵ����������Ԫ����
        System.out.println("zcount:"+jedis.zcount("scores",610,620));

        //zincrby:��ָ��ֵ�����ӷ֣����ؼӺ�ķ���
        System.out.println("zincrby:"+jedis.zincrby("scores",10,"xx"));

        //zrange:����ָ�������ֵ
        System.out.println("zrange:"+jedis.zrange("scores",0,1));

        //zrangeByScore:����ָ��������Χ�ڵĶ���
        System.out.println("zrangeByScore:"+jedis.zrangeByScore("scores",600,700));

        //zrank:����ָ��ֵ��λ�ã�������->�ߣ�0��ʼ��
        System.out.println("zrank:"+jedis.zrank("scores","yy"));

        //zrevrank:����ָ��ֵ��λ�ã�������->�ͣ�0��ʼ��
        System.out.println("zrevrank:"+jedis.zrevrank("scores", "yy"));


        //zrem:ɾ�������л���zremrangeByRank\zremrangeByScore
        System.out.println("zrem:"+jedis.zrem("scores", "yy"));

        jedis.zadd("scores", 630, "yy");
        jedis.zadd("scores", 640, "zz");
        //zrevrange����ȡָ��λ�����ݣ������Ӹ�->�ͣ�
        System.out.println(":"+jedis.zrevrange("scores",0,1));


        System.out.println("zrangeByScoreWithScores:"+jedis.zrangeByScoreWithScores("scores",600,700));

        //zscore:��ȡָ������
        System.out.println("zscore:"+jedis.zscore("scores", "xx"));
        jedis.zadd("scores_1", 630.5, "xx");
        jedis.zadd("scores_1",610.5,"bb");
        jedis.zadd("scores_1",622.5,"cc");

        //zunionstore:sortedset���ϵĲ���������,���������Ԫ����ͬ����������
        System.out.println("zunionstore:"+jedis.zunionstore("score_total","scores","scores_1"));


        ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.MAX);//ָ������������+����С�����
        zParams.weightsByDouble(1,0.1);//�����еĳ˷�����
        System.out.println("zunionstore:"+jedis.zunionstore("score_max",zParams,"scores","scores_1"));

        //zinterstore:����Ԫ��ȡ��������ͬԪ��ֵ���(Ĭ��)
        System.out.println("zinterstore:"+jedis.zinterstore("score_inter","scores","scores_1"));


        System.out.println("----------------redis-SortedSet-----------------\n");

    }
    public static void main(String[] args) {
        Jedis jedis = JEDIS_POOL.getResource();
        stringCmdTest(jedis);
        hashMapCmdTest(jedis);
        listCmdTest(jedis);
        setCmdTest(jedis);
        sortedSetTest(jedis);

        System.out.println("����ο���ַ=>http://redisdoc.com/");
    }
}*/