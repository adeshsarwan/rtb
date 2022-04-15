package com.xrtb.pojo;
import java.util.Random;
import com.xrtb.common.Configuration;

public class AudioBidResponse extends BidResponse {
    BidResponse bidResponse;

    public AudioBidResponse(BidResponse bidResponse){
        this.bidResponse = bidResponse;
    }

    public StringBuilder generateAudioBidResponse() throws Exception {
        try {
            Random ran = new Random();
            int randomIndex = ran.nextInt(3);
            response = new StringBuilder("{\"seatbid\":[{\"seat\":\"");
            response.append(Configuration.getInstance().seats.get(this.bidResponse.exchange));
            response.append("\",");

            response.append("\"bid\":[{\"id\":\"");
            response.append(this.bidResponse.br.id);                            // the impression id from the request
            response.append("\",\"impid\":\"");
            response.append(this.bidResponse.br.id);                            // the impression id from the request
            response.append("\",\"price\":");
            response.append(this.bidResponse.price);
            response.append(",\"adid\":\"");
            response.append(this.bidResponse.adid);
            response.append("\",\"cid\":\"");
            response.append(this.bidResponse.adid);
            response.append("\",\"crid\":\"");
            response.append(this.bidResponse.creat.impid);
            response.append("\",\"audio_url\":\"");
            response.append(this.bidResponse.creat.audioUrl.get(randomIndex));
            response.append("\",\"img_url\":\"");
            response.append(this.bidResponse.creat.audioImageUrl.get(randomIndex));
            response.append("\",\"click_url\":\"");
            response.append(this.bidResponse.creat.clickUrl.get(randomIndex));
            response.append("\",\"image_tracking_url\":\"");
            response.append(this.bidResponse.creat.imageTrackingUrl);
            response.append("\",\"audio_tracking_url\":\"");
            response.append(this.bidResponse.creat.audioTrackingUrl);
            response.append("\"}]}],");
            response.append("\"cur\":\"");
            response.append(this.bidResponse.creat.cur);
            response.append("\"}");
            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
