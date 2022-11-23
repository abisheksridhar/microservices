import React from 'react';
const Body =(props)=>{
    return(
        <>
            <div className="jumbotron">
                <h1>{props.Heading}</h1>
                <p>{props.body}</p>
            </div>
        </>
    )
}
export default Body;