package pro.sky.cw3.coursetask3.service;

import org.springframework.stereotype.Service;
import pro.sky.cw3.coursetask3.exeption.IncorrectParamException;
import pro.sky.cw3.coursetask3.model.Color;
import pro.sky.cw3.coursetask3.model.Size;
import pro.sky.cw3.coursetask3.model.Sock;
import pro.sky.cw3.coursetask3.model.SockItem;

import java.util.*;

@Service
public class StoreService {

    private final Map<Sock, Integer> socks = new HashMap<>();

    public void coming (SockItem sockItem) {
        if (isNotValid(sockItem)) {
            throw new IncorrectParamException();
        }
        Sock sock = sockItem.getSock();
        if (socks.containsKey(sock)) {
            socks.replace(sock, socks.get(sock) + sockItem.getQuantity());
        } else {
            socks.put(sock, sockItem.getQuantity());
        }
    }
        public void consumption(SockItem sockItem) {
            Sock sock = sockItem.getSock();
            if (!socks.containsKey(sock)) {
                throw new IncorrectParamException();
            }
            int available = socks.get(sock);
            int result = available - sockItem.getQuantity();
            if (result < 0) {
                throw new IncorrectParamException();
            }
            socks.replace(sock, result);
        }


    private boolean isNotValid(SockItem sockItem) {
        Sock sock = sockItem.getSock();
        return sock.getCottonPart() < 0 || sock.getCottonPart() > 100
                || sockItem.getQuantity() <= 0;
    }

    public int count (String color,
                            float size,
                            int cottonMin,
                            int cottonMax) {
        Color c = Color.parse(color);
        Size s = Size.parse(size);
        if (Objects.isNull(c) || Objects.isNull(s) || cottonMin >= cottonMax || cottonMin < 0 || cottonMax > 100) {
            throw new IncorrectParamException();
        }
        for (Map.Entry<Sock, Integer> entry: socks.entrySet()) {
            Sock sock = entry.getKey();
            int available = entry.getValue();
            if (sock.getColor() == c
                    && sock.getSize() == s
                    && sock.getCottonPart() >= cottonMin
                    && sock.getCottonPart() <= cottonMax) {
                return available;
            }
         }
        return 0;
    }

    public void remove(SockItem sockItem) {

    }

}
