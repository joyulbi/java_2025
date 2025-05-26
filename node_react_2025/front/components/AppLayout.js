import React, { useState , useMemo}  from 'react';   // react 불러오기   #
import PropTypes from 'prop-types'; // props 타입검사하는 역할
import Link from 'next/Link';
import { Menu, Input, Row, Col  } from 'antd';
import UserProfile from './UserProfile';
import LoginForm from './LoginForm';
import styled from 'styled-components';

import {useSelector} from 'react-redux';

const InputSearch = styled(Input.Search)`vertical-align:middle;`;


const AppLayout = ({ children }) => { 
  ///////////////////////////////////////////// code
  const items = [
     { label: <Link href="/">LOGO</Link>, key: '/' } 
    ,{ label: <Link href="/profile">PROFILE</Link>, key: '/profile' }
    ,{ label: <Link href="/signup">SIGNUP</Link>, key: '/signup' }
    ,{ label: <InputSearch  placeholder="input search text" enterButton/>, key: '/search'
    }
  ];

  /// 1. 변수 vs  useState
  // 단순대입시 state값의 변경점을 reactDom 알지 못함.
  // let logo = "My react";
  // const changeLogo = () => { console.log('..... 로고바꾸기'); logo = "welcome!";  };
  let [logo, setLogo] = useState('... TheJoa ...'); // 2번째 - 함수를 통해서 재렌더링
  const changeLogo = () => { console.log('..... 로고바꾸기'); setLogo('LOGIN');  };

  //2. login상태
  //const [isLogin, setIsLogin] = useState(false);
  
  const {user} = useSelector((state)=>state.user); //##redux 2
  
  // useMemo
  const stylebg = useMemo(() => ({ backgroundColor: '#efefef' }), []);
  
  ///////////////////////////////////////////// view
  return ( 
    <div> 
      <Menu  mode="horizontal"   items={items} />
      <Row gutter={8}>
        <Col xs={24} md={6} >
          {/*<h3 onClick={() => { console.log('....'); }} >{logo}</h3> */}
          {/* <h3 onClick={changeLogo} >{logo}</h3>*/}
          {user ? <UserProfile/> :<LoginForm/>   }  {/*##redux3*/}
        </Col>
        <Col xs={24}  md={12}  style={stylebg} > {children}  </Col>   
        <Col xs={24}  md={6} > <div>
          <a href="https://thejoa.com"
             target="_blank"
             rel="noreferrer  noopener">TheJoa</a> copyrights. all reserved. </div> </Col>
      </Row>
      </div>        
  );
}; 

AppLayout.propTypes = {
  children : PropTypes.node.isRequired
};
export default AppLayout;