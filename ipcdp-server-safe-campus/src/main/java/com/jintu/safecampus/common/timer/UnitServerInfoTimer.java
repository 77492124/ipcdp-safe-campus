package com.jintu.safecampus.common.timer;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jintu.safecampus.dal.dao.UnitServerInfoMapper;
import com.jintu.safecampus.dal.model.UnitServerInfo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

/**
 * @Classname
 * @Description 单位服务器定时任务
 * @Date 2020/1/17 15:36
 * @Created by lyx
 */

@EnableScheduling
@Component
public class UnitServerInfoTimer {

    @Resource
    private UnitServerInfoMapper unitServerInfoMapper;

    //每120s查询一次
    //@Scheduled(fixedRate=120000)
    public void e(){
        List<UnitServerInfo> unitServerInfos = unitServerInfoMapper.selectList(Wrappers.<UnitServerInfo>lambdaQuery());
        unitServerInfos.forEach(unitServerInfo->{
            boolean b = isHostConnectable(unitServerInfo.getIpAddress(), Integer.parseInt(unitServerInfo.getPortNumber()));
            if(b){
                unitServerInfo.setMarkOnline(true);
            }else{
                unitServerInfo.setMarkOnline(false);
            }
            //修改服务器在线标记
            unitServerInfoMapper.updateById(unitServerInfo);
        });
    }

    //定时任务判断ip+端口是否ping通
    public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
