-- 주문 샘플 --
-----------------------------------------------------------------------
INSERT INTO MEMBER VALUES
('admin', '1234', '관리자', '냥신사', 'nyangsinsa@gmail.com', '0202020202','서울시 강남구 역삼동 골목길');

INSERT INTO MEMBER VALUES
('kotddari', '1234', '김대현', '김양이', 'kotddari@gmail.com', '01011111111','서울시 방구 뀌길 1 101호');

INSERT INTO MEMBER VALUES
('timo', '1234', '티모', '티양이', 'timonyang2@gmail.com', '01022222222','서울시 강남구 강남동 티모네집');



-- 주문 샘플 --
-----------------------------------------------------------------------
INSERT INTO ORDER_INFO VALUES 
(ORDER_seq.NEXTVAL, 'A', SYSDATE, '인혜린', '010-6647-6105', '수원', '카카오페이');

INSERT INTO ORDER_INFO VALUES 
(ORDER_seq.NEXTVAL, 'B', SYSDATE, '이정아', '010-6644-6105', '안양', '네이버페이');

INSERT INTO ORDER_INFO VALUES 
(ORDER_seq.NEXTVAL, 'C', SYSDATE, '권준형', '010-6332-6105', '인천', '무전취물');

INSERT INTO ORDER_INFO VALUES 
(ORDER_seq.NEXTVAL, 'D', SYSDATE, '강문영', '010-6543-6105', '서울', '외상');

INSERT INTO ORDER_INFO VALUES 
(ORDER_seq.NEXTVAL, 'E', SYSDATE, '김대현', '010-1234-6105', '서울', '신용카드');
-------------------------------------------------------------------------
/*TO_CHAR(SYSDATE,'YYYY-MM-DD')*/



-- 주문 상세 샘플 --
-----------------------------------------------------------------------
INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,1,5);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,3,2,50);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,4,3,15);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,5,4,25);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,1,5,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,2,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,2,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,4,5,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,3,1,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,5,3,5);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,5,5);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,1,5);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,3,2,50);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,4,3,15);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,5,4,25);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,1,5,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,2,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,2,2,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,4,5,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,3,1,30);

INSERT INTO ORDER_DETAIL values(order_detail_seq.NEXTVAL,5,3,5);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,20,40);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,38,50);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,39,33);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,25,40);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,46,40);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,27,80);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,26,90);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,20,10);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,3,80);

INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.NEXTVAL,4,45,100);
