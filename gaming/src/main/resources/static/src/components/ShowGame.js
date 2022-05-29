import React from "react";
import { useState } from "react";
import { Card } from "react-bootstrap";
import { Button } from "react-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faComputer } from "@fortawesome/free-solid-svg-icons";
import { faPlayStation } from "@fortawesome/free-solid-svg-icons";
import { faXbox } from "@fortawesome/free-solid-svg-icons"


export default function ShowGame(props) {
    const [isEditing, setIsEditing] = useState(false);
    const [name, setName] = useState(props.game.name);
    const [description, setDescription] = useState(props.game.description);
    const [price, setPrice] = useState(props.game.price);
    const [categoryId, setCategoryId] = useState(props.game.category.id);
    const [categoryName, setCategoryName] = useState(props.game.category.name);
    const [creatorId, setCreatorId] = useState(props.game.creator.id);
    const [creatorName, setCreatorName] = useState(props.game.creator.name);
    const [psVersion, setPSVersion] = useState(props.game.psVersion);
    const [xboxVersion, setXBoxVersion] = useState(props.game.xboxVersion);
    const [pcVersion, setPcVersion] = useState(props.game.pcVersion);
    const [phoneVersion, setPhoneVersion] = useState(props.game.phoneVersion);
    const [img, setImg] = useState(props.game.img);

    const handleUpdateGame = () => {
        setIsEditing(!isEditing);
        props.updateGame({
            name: name,
            description: description,
            price: price,
            category: {
                id: categoryId,
                name: categoryName,
            },
            creator: {
                id: creatorId,
                name: creatorName,
            },
            psVersion: psVersion,
            xboxVersion: xboxVersion,
            pcVersion: pcVersion,
            phoneVersion: phoneVersion,
            img: img
        })
    }

    let url = `img/${props.game.img}`;


        return(
            <div className="show-game">
                   <Card style={{ width: '18rem' }} className="card-game">
                    <Card.Img variant="top" src={url} className="card-img"/>
                    <Card.Body>
                        <Card.Title>{props.game.name}</Card.Title>
                        <Card.Text className="card-text">
                                <p>{props.game.description}</p>
                                <p>{props.game.price} €</p>
                                <p>DISPONIBILE PER:</p>
                                {props.game.psVersion ? 'play' : null}
                                {props.game.xboxVersion ? 'xbox': null}
                                {props.game.pcVersion ? <FontAwesomeIcon icon={faComputer}/> : null} 
                                {props.game.phoneVersion ? 'phone' : null}                                                          
                        </Card.Text>
                        <Button variant="primary" className="btn btn-primary">ADD TO SHOP</Button>
                    </Card.Body>
                </Card>                 
                <hr/>
            </div>
        )
}
