package com.manhcode.rest.jaxrs.asynchronous.status;

import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

@Service
public class CheckProcessorImpImpl implements CheckProcessor {
    @Override
    public void processChecks(AsyncResponse response, CheckList checkList) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /*
                Logic code here

                 */
                if (checkList == null || checkList.getChecks() == null || checkList.getChecks().size() == 0) {
                    response.resume(new BadRequestException());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                response.resume(true); // response to client
            }
        }).start();
    }
}
