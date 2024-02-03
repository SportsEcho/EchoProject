package com.sportsecho.hotdeal.service;

import com.sportsecho.hotdeal.dto.request.HotdealRequestDto;
import com.sportsecho.hotdeal.dto.request.PurchaseHotdealRequestDto;
import com.sportsecho.hotdeal.dto.request.SetUpHotdealRequestDto;
import com.sportsecho.hotdeal.dto.request.UpdateHotdealInfoRequestDto;
import com.sportsecho.hotdeal.dto.response.HotdealResponseDto;
import com.sportsecho.hotdeal.dto.response.HotdealWaitResponse;
import com.sportsecho.hotdeal.dto.response.PurchaseHotdealResponseDto;
import com.sportsecho.member.entity.Member;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface HotdealService {

    /**
     * Hotdeal 생성
     *
     * @param productId  Hotdeal을 생성할 Product의 Id
     * @param requestDto Hotdeal 생성 요청 정보
     * @return 생성된 Hotdeal 정보
     */
    HotdealResponseDto createHotdeal(Long productId, HotdealRequestDto requestDto);

    /**
     * Hotdeal 목록 조회
     *
     * @param pageable 페이징 정보
     * @return Hotdeal 목록
     */
    List<HotdealResponseDto> getHotdealList(Pageable pageable);

    /**
     * Hotdeal 조회
     *
     * @param hotdealId 조회할 Hotdeal의 Id
     * @return 조회된 Hotdeal 정보
     */
    HotdealResponseDto getHotdeal(Long hotdealId);

    /**
     * Hotdeal 정보 수정
     *
     * @param hotdealId  수정할 Hotdeal의 Id
     * @param requestDto 수정할 Hotdeal 정보
     * @return 수정된 Hotdeal 정보
     */
    HotdealResponseDto updateHotdeal(Long hotdealId, UpdateHotdealInfoRequestDto requestDto);

    /**
     * Hotdeal 삭제
     *
     * @param hotdealId 삭제할 Hotdeal의 Id
     * @return 삭제된 Hotdeal 정보
     */
    void deleteHotdeal(Long hotdealId);

    /**
     * Hotdeal 구매
     *
     * @param member     구매자 정보
     * @param requestDto 구매할 Hotdeal 정보
     * @return 구매된 Hotdeal 정보
     */
    PurchaseHotdealResponseDto purchaseHotdeal(Member member,
        PurchaseHotdealRequestDto requestDto);

    /**
     * Hotdeal 구매 대기
     *
     * @param hotdealId 구매 대기할 Hotdeal의 Id
     * @param member    구매자 정보
     * @return 성공 유무
     */
    HotdealWaitResponse waitHotdeal(String hotdealId, Member member);

    /**
     * Hotdeal 구매 대기 취소
     *
     * @param hotdealId 구매 대기 취소할 Hotdeal의 Id
     * @param member    구매자 정보
     */
    void deleteHotdealWaitingMember(Member member, String hotdealId);

    /**
     * Hotdeal 대기열 확인
     *
     * @param hotdealId 대기열을 확인할 Hotdeal의 Id
     * @param member    구매자 정보
     * @return 대기열에 순번이 왔는지 여부
     */
    boolean isMyHotdealTurn(Member member, String hotdealId);

    /**
     * Hotdeal 구매 V3
     *
     * @param member     구매자 정보
     * @param requestDto 구매할 Hotdeal 정보
     * @return 구매된 Hotdeal 정보
     */
    void purchaseHotdealV3(Member member, PurchaseHotdealRequestDto requestDto);

    /**
     * 스케줄러에 hotdeal 세팅
     *
     * @param hotdealId  이벤트를 진행할 핫딜 Id
     * @param requestDto 대기열에서 주문창으로 넘길 인원수
     */
    void setUpHotdeal(Long hotdealId, SetUpHotdealRequestDto requestDto);

}
